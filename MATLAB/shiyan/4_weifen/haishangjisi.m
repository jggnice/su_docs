function dx=haishangjisi(t,x)
a=20;b=40;c=15;
s=sqrt((c-x(1))^2+(a*t-x(2))^2);
dx=[b*(c-x(1))/s;b*(a*t-x(2))/s];
