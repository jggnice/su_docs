ts=60:0.5:72;
y0=[height,vmax];
[t1,y]=ode45(@huojian2,ts,y0);

figure(1)
plot(t1,y(:,2)),grid,xlabel('t'),ylabel('v');
hold on;plot(t,x(:,2));hold off
figure(2)
plot(t1,y(:,1)),grid,xlabel('t'),ylabel('x');
hold on;plot(t,x(:,1));hold off
maxheight=max(y(:,1))
vend=y(end,2)

vv1=x(:,2);
m0=1400;ms=18;F0=32000;
mt=m0-ms*t;f1=0.4*vv1.^2;

a1=(F0-f1-9.8*mt)./mt;
figure(3);
plot(t,a1);grid;hold on

vv2=y(:,2);
mm=1400-1080;f2=0.4*vv2.^2;

a2=-(mm*9.8+f2)./mm;
% size(f2)
% size(a2)
plot(t1,a2);hold off
gtext('加速度a');gtext('时间t');
