% ��ѧ��ѧʵ��2p.255 ʵ��11 ��1, ���еĹ�̨�߶�����
clear all; clc; clf;	     %������б�����������ڣ���ͼ�δ���
A = dlmread('bankdata.m');   %����
X = [A(1,:) A(2,:) A(3,:) A(4,:) A(5,:)];     % ������
[N,Y]=hist(X)	% Ƶ����
hist(X)		% ֱ��ͼ
x1=mean(X) 	% ����ͳ����:��ֵ,��λ��,����,��׼��,ƫ��,���
x2=median(X) 	
x3=range(X)
x4=std(X)
x5=skewness(X)
x6=kurtosis(X)

