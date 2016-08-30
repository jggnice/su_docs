clc;clear;
b=[0 0 5 3 0];
s=diag([0.4 0.6 0.6 0.4]);
L=[b;s,zeros(4,1)];
h=[500 400 200 100 100];
x(:,1)=[8481 2892.4 1335.4 601.3 140.5];
for ii=1:30
    x(:,ii+1)=L*x(:,ii)-h';
end
round(x);
ii=0:30;
plot(ii,x);grid;