package com.prabhash.codejam.google.year2016.qualifying.coinjam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTask extends RecursiveAction {
	
	private long workload = 10;
	private final List<Integer> computeList = new ArrayList<>();
	private static int count = 1;
	
	public ForkJoinTask(long workload) {
		this.workload = workload;
	}
	
	@Override
	public void compute() {
		
		while(workload > 10) {
			
			List<ForkJoinTask> taskList = new ArrayList<>();
			taskList.addAll(createSubTasks());
			
			for(RecursiveAction subTask : taskList) {
				
				subTask.fork();
			}
		}
		
		if(workload <= 10){
			
			System.out.println("Do the work..");
			computeList.add(count);
			count++;
		}
	}
	
	private List<ForkJoinTask> createSubTasks() {
		
		List<ForkJoinTask> list = new ArrayList<>();
		
		ForkJoinTask task1 = new ForkJoinTask(this.workload / 2);
		ForkJoinTask task2 = new ForkJoinTask(this.workload / 2);
		
		list.add(task1);
		list.add(task2);
		return list;
	}
	
	public static void main(String[] args) {
		
		ForkJoinTask task = new ForkJoinTask(500);
		
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
	}
}
