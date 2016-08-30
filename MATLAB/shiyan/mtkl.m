clc;clear;
u=1:.001:3;
uu=exp(4*u).*sin(5*u);
mm=max(uu)%取值
mn=min(uu)%取值
plot(u,uu);grid on
n=10^6; %% 计算精度
count=0;count1=0; %% count为上频数，count1为下频数。
x=unifrnd(1,3,[1 n]); %% 积分区间内产生n个随机数（均匀分布）
y=unifrnd(mn,mm,[1 n]);%% 积分区间内产生n个随机数（均匀分布）
% for (i=1:n) 
% x(i)=A(i);
% y(i)=B(i);
% end
%%开始计算函数
for i=1:n
if ((y(i)<=exp(4*x(i))*sin(5*x(i)))&&(y(i)>0)) 
count=count+1;
end
if((y(i)>=exp(4*x(i))*sin(5*x(i)))&&(y(i)<0))
    count1=count1+1;
end
end
j=(count-count1)/n
j*(mm-mn)*2
