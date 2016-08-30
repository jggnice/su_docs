
ts=0:0.5:60;
x0=[0,0];
[t,x]=ode45(@huojian,ts,x0);
figure(1);plot(t,x(:,2));grid;
figure(2);plot(t,x(:,1));grid;

vv=x(:,2)';
m0=1400;ms=18;F0=32000;
mt=m0-ms*ts;f1=0.4*vv.^2;
size(f1)
ma=(F0-f1-9.8*mt)./mt;
figure(3);
plot(t,ma);grid;