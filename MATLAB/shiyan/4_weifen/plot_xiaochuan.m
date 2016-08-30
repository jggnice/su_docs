ts=0:0.5:180;
y0=[0,-100];
[t,y]=ode15s(@xiaochuan,ts,y0);
figure(1);plot(t,y);legend('x;v1=1.5','y;v1=1.5');grid;
figure(2);plot(y(:,1),y(:,2));legend('(x,y);v1=2');grid;
[t,y]