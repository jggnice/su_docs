clear;clc;
ts=pi/2:0.1:15;
y1=sqrt(2*pi./ts).*sin(ts);
y0=[2,-2/pi];
[t,y]=ode45(@longge,ts,y0);
figure(1)
plot(ts,y1,'r');xlabel('ts'),ylabel('y')
legend('y1=sqrt(2*pi./ts).*sin(ts);');
grid 
figure(2)
plot(ts,y(:,1));grid
xlabel('ts'),ylabel('y')
legend('longge solution');