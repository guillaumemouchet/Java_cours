
package ch.arc.cours.lamda.image.framework.animation;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import ch.arc.cours.lamda.image.framework.image.JPanelImage;
import ch.arc.tools.Chrono;

public class Animator implements Animator_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Animator(Animable_I animable)
		{
		// Inputs
			{
			this.animable = animable;
			this.optionalDessinale = Optional.empty();
			}

		// Tools
			{
			this.isAnimationStart = new AtomicBoolean(false);
			this.isDessinPerformed = new AtomicBoolean(false);
			}

		// Output
			{
			this.fps = -1;
			}
		}

	public void registry(JPanelImage jripping)
		{
		this.optionalDessinale = Optional.of(jripping);
		jripping.addDessinListener(() -> isDessinPerformed.set(true));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public synchronized void start()
		{
		if (isAnimationStart.get())
			{
			System.err.println("[Animator] : start : animation already started");
			}
		else
			{
			isAnimationStart.set(true);

			futur = EXECUTOR_SERVICE.submit(() -> animation());
			}
		}

	@Override
	public synchronized void stop()
		{
		if (!isAnimationStart.get())
			{
			System.err.println("[Animator] : Warning : stop ask : animation already stopped, or never started!");
			}
		else
			{
			isAnimationStart.set(false);

			// attente de fin naturel du thread d'animation
				{
				try
					{
					futur.get();
					}
				catch (InterruptedException | ExecutionException e)
					{
					e.printStackTrace();
					}
				}
			}
		}

	@Override
	public boolean isStarted()
		{
		return isAnimationStart.get();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public double getFps()
		{
		return this.fps;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void animation()
		{
		long nbIteration = 0;
		long timeTotMS = 0;
		List<Long> lastTime = new LinkedList<Long>();
		Chrono chrono = new Chrono();

		while(isAnimationStart.get())
			{
			long timeMS = animable.animationStep(nbIteration);
			timeTotMS += timeMS;
			lastTime.add(timeMS);

			nbIteration++;

			optionalDessinale.ifPresent(this::dessine);
			}

		chrono.stop();

		// Differnetes version, mediane est la plus fiable (tient pas compte des valeurs limites)
		double fps_v1 = fps(nbIteration, timeTotMS);
		double fps_v2 = fps(nbIteration, chrono.getTimeMS());
		double fps_v3 = fps(1, mediane(lastTime));

		// print
			{
			System.out.println("\n[Animator] : fps (v1)  = " + toString(fps_v1) + " (mean sum local)");
			System.out.println("\n[Animator] : fps (v2)  = " + toString(fps_v2) + " (mean global)");
			System.out.println("\n[Animator] : fps (v3)  = " + toString(fps_v3) + " (mediane)");

			// debug
			System.out.println("\n[Animator] : Time By Iteration [ms] = " + lastTime.stream().mapToLong(Long::valueOf).summaryStatistics());
			System.out.println("\n[Animator] : Time By Iteration [ms] = " + lastTime + "\n");
			}

		this.fps = fps_v3;// mediane
		}

	/*------------------------------*\
	|*			  Dessine			*|
	\*------------------------------*/

	private void dessine(Dessinable_I dessinable)
		{
		dessinable.repaint();// async
		waitRenduDessin();
		}

	/**
	 * <pre>
	 * repaint est async
	 * Avant de lancer le calcul de l'image suivante, on attend que le rendu soit finit
	 * En pratique le rendu est tres rapide et on a pas besoin d'attendre, mais mieux vaut prevenir que guerir!
	 * </pre>
	 */
	private void waitRenduDessin()
		{
		while(!isDessinPerformed.get())
			{
			sleep(10); // n'arrive que tres rarement
			}

		isDessinPerformed.set(false);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	/**
	 * <pre>
	 * on trie, puis on prend l'element milieux si la taille est impaire,
	 * la moyenne des deux elements centraux si la taille est apire
	 * </pre>
	 */
	private static long mediane(List<Long> list)
		{
		int middle = list.size() / 2;

		int skip = 0; //#elements a elever en tete de stream
		int limit = 0;//#elements a garder dans la stream depuis la coupure skip
		if (list.size() % 2 == 0)
			{
			skip = middle - 1;
			limit = 2;
			}
		else
			{
			skip = middle;
			limit = 1;
			}

		return (long)list.stream().sorted().skip(skip).limit(limit).mapToLong(Long::valueOf).summaryStatistics().getAverage();
		}

	private static double fps(long nbIteration, long delayMS)
		{
		return 1000 * nbIteration / (double)delayMS;
		}

	/**
	 * une decimale
	 */
	private static String toString(double fps)
		{
		return String.format("%.1f", fps);
		}

	private static void sleep(long delayMS)
		{
		try
			{
			Thread.sleep(delayMS);
			}
		catch (InterruptedException e)
			{
			// rien
			}
		}

	/**
	 * <pre>
	 * Utile pour visualvm et debug
	 * ThreadFactory permet de donner un nom aux threads
	 * </pre>
	 */
	private static ExecutorService create()
		{
		ThreadFactory threadFactory = new ThreadFactory()
			{

			@Override
			public Thread newThread(Runnable runnable)
				{
				Thread thread = new Thread(runnable);
				thread.setName("Animator_" + COMPTEUR.getAndIncrement());
				return thread;
				}
			};

		return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), threadFactory);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Animable_I animable;
	private Optional<Dessinable_I> optionalDessinale;
	private double fps;

	// Tools
	private AtomicBoolean isAnimationStart;
	private Future<?> futur;
	private AtomicBoolean isDessinPerformed;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final AtomicInteger COMPTEUR = new AtomicInteger(0);
	private static final ExecutorService EXECUTOR_SERVICE = create();

	}
