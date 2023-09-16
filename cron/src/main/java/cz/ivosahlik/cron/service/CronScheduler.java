package cz.ivosahlik.cron.service;

@FunctionalInterface
public interface CronScheduler {

    void process();

}
