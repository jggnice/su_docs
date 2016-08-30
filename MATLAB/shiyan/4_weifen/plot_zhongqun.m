ts=0:0.1:200;
x0=[10,10];%
[t,x]=ode45(@zhongqun,ts,x0);
figure(1);plot(t,x);grid;legend('a_1zhongqun','b_2zhongqun');
title('r1=2;r2=1;n1=100;n2=100;s1=1.5;s2=1.7;')
figure(2);plot(x(:,1),x(:,2));grid;legend('xiangtu');
title('r1=2;r2=1;n1=100;n2=100;s1=1.5;s2=1.7;')