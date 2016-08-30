function dx=zhongqun(t,x)
r1=2;r2=1;n1=100;n2=100;s1=1.5;s2=1.7;
dx=[r1*x(1)*(1-x(1)/n1-s1*x(2)/n2);r2*x(2)*(1-s2*x(1)/n1-x(2)/n2)];
