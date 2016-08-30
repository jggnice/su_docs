function result=ex224logistic(ta,x,t0,ts,te)
% 阻滞增长模型
% 对相关数据 rx = dx/dt/x 用数值微分三点公式（见教材 p71）
% 方法1: rx 从全部数据中取  
% 方法2: rx 从指定数据中取
% 输出: ta: 年份数据列， x: 人口数据列，t0: 方法1的rx数据的起始年，ts,te: 起始、结束年份 
% 输出: 2*7矩阵 方法(1:2)  年(ts)  ~  年(te)  x0年(t0)  r   xm   预测下一期(xhat(n+1))
%
t01=find(ta>=t0);	t01=t01(1);   % 年份t0对应的x的下标
ts1=find(ta>=ts);	ts1=ts1(1);   % 开始年份ts对应的x的下标
te1=find(ta>=te);	te1=te1(1);   % 结束年份te对应的x的下标

%方法1----------------------------------------------------------------------
xx = x(1:te1);	
n = length(xx);  	n1=n-1;		      % n 必须大于等于 3
rx = (1:n)'; 
rx(1) = (-3*xx(1)+4*xx(2)-xx(3));	
rx(n)=(3*xx(n)-4*xx(n-1)+xx(n-2));
rx(2:n1) = xx(3:n)-xx(1:(n-2));
%for i=2:n1;  	yb(i)=y(i+1)-y(i-1); 	end;

rx = rx(ts1:te1);	xx = xx(ts1:te1);	n = length(xx);
rx = rx/2./xx;	tb = [ones(n,1) xx]; 	b1 = regress(rx,tb); 
r = b1(1);	xm = -b1(1)/b1(2);

% 预测下一期 x(n+1)
%'方法  年  ~  年   x0年      r       xm   预测下一期'
% r=.2557;	xm=392.0886;		% 教材1860~1990结果
% r=.2490;	xm=433.9886;		% 教材1860~2000结果
xn1 = xx(n)+r*xx(n)*(1-xx(n)/xm);
result=[1,ts,te,t0,r,xm,xn1];  
disp(['  1  ',int2str(ts),' ~ ',int2str(te),'  ',int2str(t0),'  ', num2str(r),'  ',num2str(xm),'  ',num2str(xn1)])

%方法2-----------------------------------------------------------------------
y=x(ts1:te1);	
nn=size(y);  	n=nn(1);    		n1=n-1;		% n 必须大于等于 3
yb=1:n; yb=yb';
yb(1)=(-3*y(1)+4*y(2)-y(3));	yb(n)=(3*y(n)-4*y(n-1)+y(n-2));
for i=2:n1;  	yb(i)=y(i+1)-y(i-1); 	end;

yb=yb/2./y;	tb=[ones(n,1) y]; 	b1=regress(yb,tb); 
r=b1(1);	xm=-b1(1)/b1(2);

% 预测下一期 x(n+1)
%'方法  年  ~  年   x0年      r       xm   预测下一期'
xn1 = xx(n)+r*xx(n)*(1-xx(n)/xm);
result(2,:)=[2,ts,te,t0,r,xm,xn1];  
disp(['  2  ',int2str(ts),' ~ ',int2str(te),'  ',int2str(t0),'  ', num2str(r),'  ',num2str(xm),'  ',num2str(xn1)])
