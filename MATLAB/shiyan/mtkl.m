clc;clear;
u=1:.001:3;
uu=exp(4*u).*sin(5*u);
mm=max(uu)%ȡֵ
mn=min(uu)%ȡֵ
plot(u,uu);grid on
n=10^6; %% ���㾫��
count=0;count1=0; %% countΪ��Ƶ����count1Ϊ��Ƶ����
x=unifrnd(1,3,[1 n]); %% ���������ڲ���n������������ȷֲ���
y=unifrnd(mn,mm,[1 n]);%% ���������ڲ���n������������ȷֲ���
% for (i=1:n) 
% x(i)=A(i);
% y(i)=B(i);
% end
%%��ʼ���㺯��
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
