clear;clc;
load datas
%数据采集
%1~12求和6k+1
%频数，3：，8：
p0i=1/12;
datasort=datas(:,[3 8]);
n1=sum(sum(datasort(1:6,:)));
n2=sum(sum(datasort(6*3+1:6*4,:)));
u1=n1*p0i;u2=n2*p0i;
datasort(1:6,:)=(datasort(1:6,:)-u1).^2;
datasort(6*3+1:6*4,:)=(datasort(6*3+1:6*4,:)-u2).^2;
sumdata1=sum(sum(datasort(1:6,:)));
sumdata2=sum(sum(datasort(6*3+1:6*4,:)));
sumdata1=sumdata1/u1;
sumdata2=sumdata2/u2;