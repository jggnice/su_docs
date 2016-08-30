% 大学数学实验2p.255 实验11 例1, 银行的柜台高度问题
clear all; clc; clf;	     %清除所有变量，清命令窗口，关图形窗口
A = dlmread('bankdata.m');   %矩阵
X = [A(1,:) A(2,:) A(3,:) A(4,:) A(5,:)];     % 行向量
[N,Y]=hist(X)	% 频数表
hist(X)		% 直方图
x1=mean(X) 	% 各个统计量:均值,中位数,极差,标准差,偏度,峰度
x2=median(X) 	
x3=range(X)
x4=std(X)
x5=skewness(X)
x6=kurtosis(X)

