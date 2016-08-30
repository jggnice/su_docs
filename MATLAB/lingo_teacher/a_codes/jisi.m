function dx=jisi(t,x)
a=20;b=40;c=15;
r=pi/4;                           %      ×ßË½´¬·½Ïò
s=sqrt((c-x(1)+a*t*cos(r))^2+(a*t*sin(r)-x(2))^2);
dx=[b*(c-x(1)+a*t*cos(r))/s;b*(a*t*sin(r)-x(2))/s];
