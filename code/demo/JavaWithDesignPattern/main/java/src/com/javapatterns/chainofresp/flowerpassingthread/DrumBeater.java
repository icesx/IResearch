package com.javapatterns.chainofresp.flowerpassingthread;

import java.util.Timer;
import java.util.TimerTask;

public class DrumBeater
{
    private static Player firstPlayer;
    private static boolean stopped = false;
    private Timer timer;

    public static void main(String[] args)
    {
        DrumBeater drumBeater = new DrumBeater();

        JiaMu jiaMu = new JiaMu(null);

        jiaMu.setSuccessor(new JiaShe(
        new JiaZheng(
        new JiaBaoYu(
        new JiaHuan(jiaMu)))));

        drumBeater.startBeating(1);

        firstPlayer = jiaMu;
        firstPlayer.handle();

    }

    public void startBeating(int stopInSeconds)
    {
        System.out.println("Drum beating started...");

        timer = new Timer();
        timer.schedule(new StopBeatingReminder(), stopInSeconds * 1000);

    }

    public static boolean getStopped()
    {
        return stopped;
    }

    class StopBeatingReminder extends TimerTask
    {
        public void run()
        {
            System.out.println("Drum beating stopped!");
            stopped = true;
            timer.cancel(); //Terminate the timer thread
        }
    }

}
