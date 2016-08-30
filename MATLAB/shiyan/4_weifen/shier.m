function xdot=shier(t,x)
r=0.5;d=0.5;a=0.1;b=0.02;
xdot=diag([r-a*x(2),-d+b*x(1)])*x;