clear;clc;
ts=0:0.05:0.5;x0=[0,0];
[t,x]=ode45(@haishangjisi,ts,x0);
t,x,
plot(t,x),grid
gtext('x(t)'),gtext('y(t)'),pause
plot(x(:,1),x(:,2))
grid,
gtext('x'),gtext('y'),