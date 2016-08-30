a=0.1;b=5;
x0=100;y0=10;x(1)=110;
y(1)=y0-a*(x(1)-x0);
for k=2:10
x(k)=x0-a*b*(x(k-1)-x0);
y(k)=y0-a*(x(k)-x0);
end
figure(1);plot(x);grid;legend('x_k')
figure(2);plot(y);grid;legend('y_k')