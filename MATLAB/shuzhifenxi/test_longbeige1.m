%梯形公式对分区间求积分
clc;clear;
format long
a=0;b=1;dx=1e-6;
n=1;h=(b-a)/2;

T0=h*(f1(a)+f1(b));
%尚未对分区间
count=0;

Fsum=0;
for ii=1:n
    Fsum=Fsum+f1(a+(2*ii-1)*h);
    T=T0/2+h*Fsum;
end

while(abs(T-T0)>=3*dx)  
    n=2*n;
    %对分1次
count = count + 1;
    h=h/2;
    T0=T;
Fsum=0;
for ii=1:n
    Fsum=Fsum+f1(a+(2*ii-1)*h);    
end  
T=T0/2+h*Fsum;

end
'积分值'
disp(T),
'对分次数'
disp(count),
'区间数'
disp(n),
'Standard=pi/4='
disp(pi/4),
format short
