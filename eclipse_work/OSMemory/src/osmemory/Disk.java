package osmemory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Disk
{
	static Part head;
	static Part h1 = new Part(false, 0, 0, 1000000000);
	static Part h2 = new Part(false, 0, 0, 1000000000);
	static long size;
	static ArrayList<Part> partlist = new ArrayList<Part>();
	static ArrayList<Job> jobs = new ArrayList<Job>();
	static ArrayList<Job> waitjobs = new ArrayList<Job>();
	public static void init(long size)
	{
		partlist.removeAll(partlist);

		head = new Part(true, 0, size, 0);
		head.pre = h1;
		head.next = h2;
		h1.next = head;
		h2.pre = head;
		partlist.add(head);
	}
	public static void dealloc(Part part)
	{
		Part p1 = part.pre;
		Part p2 = part.next;
		if (p1.status)
		{
			if (p2.status)
			{
				p1.size = p1.size + part.size + p2.size;
				p1.next = p2.next;
				p2.next.pre = p1;
			} else
			{
				p1.size = p1.size + part.size;
				p1.next = p2;
				p2.pre = p1;
			}
		} else
		{
			if (p2.status)
			{
				part.status = true;
				part.size = part.size + p2.size;
				part.next = p2.next;
				p2.next.pre = part;
			} else
			{
				part.status = true;
			}
		}
		partlist.remove(part);
	}
	public static boolean allocate(Job job)
	{
		for (Part part : partlist)
		{
			// 禁止新建空分区
			if (part.status && (part.size > job.memory))
			{
				Part p1 = part.pre;
				// Part p2 = part.next;
				Part p = new Part(false, part.start, job.memory, job.time);

				p.pre = p1;
				p1.next = p;
				// //////////////////////////////////
				part.start = (int) (p.start + p.size);
				part.size -= p.size;

				p.next = part;
				part.pre = p;
				partlist.add(p);
				return true;
			}
		}
		return false;

	}
	public static void main(String[] args)
	{
		ArrayList<Job> deletejobs = new ArrayList<Job>();
		int numofline;
		System.out.println("input");
		Scanner sc = new Scanner(System.in);
		numofline = sc.nextInt();
		Disk.size = sc.nextLong();
		 numofline = 70;
		Job.currenttime = 0;
		Disk.init(Disk.size);
		System.out.println();
		System.out.println(numofline + "," + Disk.size);
		for (int i = 0; i < numofline; i++)
		{
			jobs.add(new Job(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		sc.close();
		// jobs.sort(new memComparator());
		// for (Job jb : jobs)
		// {
		// System.out.println(jb.memory);
		// }

		// /////////////////////////////////////////////
		// /////////////////////////////////////////////

		while (jobs.size() > 0 || waitjobs.size() > 0)
		{
			if (waitjobs.size() == 0)
			{
				Job.currenttime = jobs.get(0).arrive;
			}
			// 时间触发等待
			for (; 0 < jobs.size() && jobs.get(0).arrive <= Job.currenttime;)
			{
				waitjobs.add(jobs.get(0));
				jobs.remove(0);
			}
			// 等待触发载入
			deletejobs.removeAll(deletejobs);
			for (Job jb : waitjobs)
			{
				if (Disk.allocate(jb))
				{
					deletejobs.add(jb);
				}
			}
			for (Job jb : deletejobs)
			{
				waitjobs.remove(jb);
			}
			int tim = 10000;
			Part a = null;
			// 终止时间———排序
			for (Part p : partlist)
			{
				if (p.status)
				{
					if (tim > p.endtime)
					{
						tim = p.endtime;
						a = p;
					}

				}
			}
//			if (null != a)
//			{
//				System.out.println("rrrr");
//				Job.currenttime = a.endtime;
//				Disk.dealloc(a);
//				System.out.println("eeeeeee");
//			}
			// /////////////////////////////////
			// /////////////////////////////////
			// 回收——改时间——跳转

		}// 全部载入完毕
		for (Part p1 : partlist)
		{

			if (Job.currenttime < p1.endtime)
			{
				Job.currenttime = p1.endtime;
			}
		}
		// 全部运行完毕
		System.out.println(Job.currenttime);
	}
}
// Iterator<Part> iterator = partlist.iterator();
// boolean flag = false;
//
// for (Part p1 : partlist)
// {
// if (!flag && !p1.status)
// {
// Job.currenttime = p1.endtime;
// flag = true;
// }
// if (flag)
// {
// if (p1.endtime == Job.currenttime)
// {
// Disk.dealloc(p1);
// } else
// {
// break;
// }
// }
//
// }
// int n = 0;
// for (int i = 0; i < partlist.size(); i++)
// {
// Part p1 = partlist.get(i);
// if (!p1.status)
// {
// Job.currenttime = p1.endtime;
// n = i;
// break;
// }
// }
// for (int i = n; i < partlist.size(); i++)
// {
// Part p1 = partlist.get(i);
// if (p1.endtime == Job.currenttime)
// {
// Disk.dealloc(p1);
// } else
// {
// break;
// }
// }