x = [3.9 5.3 7.2 9.6 12.9 17.1 23.2 31.4 38.6 50.2 62.9 76 92 106.5 123.2 131.7 150.7 179.3 204 226.5 251.4 281.4]';
y = log(x);

answ.a = '指数增长模型 1790~1900';
yb = y(1:12);
tb = [ones(12,1) [0:11]'];
[b1,bint1,r1,rint1,stats1] = regress(yb,tb);
answ.r = b1(2);
answ.x0 = exp(b1(1))

answ.a = '指数增长模型 1790~2000';
yb=y(1:22);
tb=[ones(22,1) [0:21]'];
[b1,bint1,r1,rint1,stats1]=regress(yb,tb);
answ.r = b1(2);
answ.x0 = exp(b1(1))

answ.a = '指数增长模型 1900~2000';
yb=y(12:22);
tb=[ones(11,1) [0:10]'];
[b1,bint1,r1,rint1,stats1]=regress(yb,tb);
answ.r = b1(2);
answ.x0 = exp(b1(1))

% 阻滞增长模型 中 r(x)=(dx/dt)/x 的计算(4.2 p.71)
n = length(x) 
rx(1) = (-3*x(1)+4*x(2)-x(3))/(20*x(1));
rx(n) = (3*x(n)-4*x(n-1)+x(n-2))/(20*x(n));
rx(2:(n-1)) = (x(3:n) - x(1:(n-2)))./(20*x(2:(n-1)));
rx = rx'


'阻滞增长模型1790~2000  r   xm'     %只要确定y, 后面全相同
y=rx(1:22);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1860~1990  r   xm'
y=x(8:21);    nn=length(y); 
yb=rx(8:21);
tb=[ones(nn,1) y];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1870~1990  r   xm'
y=x(9:21);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1880~1990  r   xm'
y=x(10:21);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1890~1990  r   xm'
y=x(11:21);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1900~1990  r   xm'
y=rx(12:21);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1860~1930  r   xm'
y=x(8:15);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1950~1990  r   xm'
y=x(17:21);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1950~2000  r   xm'
y=x(17:22);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1860~2000  r   xm'
y=x(8:22);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]

'阻滞增长模型1790~1980  r   xm'
y=x(1:20);    nn=size(y);  n2=nn(1);  n1=n2-1;
yb=(y(2:n2)-y(1:n1))./y(1:n1);tb=[ones(n1,1) y(1:n1)];b1=regress(yb,tb); 
result=[b1(1),-b1(1)/b1(2)]