function result=ex224logistic(ta,x,t0,ts,te)
% ��������ģ��
% ��������� rx = dx/dt/x ����ֵ΢�����㹫ʽ�����̲� p71��
% ����1: rx ��ȫ��������ȡ  
% ����2: rx ��ָ��������ȡ
% ���: ta: ��������У� x: �˿������У�t0: ����1��rx���ݵ���ʼ�꣬ts,te: ��ʼ��������� 
% ���: 2*7���� ����(1:2)  ��(ts)  ~  ��(te)  x0��(t0)  r   xm   Ԥ����һ��(xhat(n+1))
%
t01=find(ta>=t0);	t01=t01(1);   % ���t0��Ӧ��x���±�
ts1=find(ta>=ts);	ts1=ts1(1);   % ��ʼ���ts��Ӧ��x���±�
te1=find(ta>=te);	te1=te1(1);   % �������te��Ӧ��x���±�

%����1----------------------------------------------------------------------
xx = x(1:te1);	
n = length(xx);  	n1=n-1;		      % n ������ڵ��� 3
rx = (1:n)'; 
rx(1) = (-3*xx(1)+4*xx(2)-xx(3));	
rx(n)=(3*xx(n)-4*xx(n-1)+xx(n-2));
rx(2:n1) = xx(3:n)-xx(1:(n-2));
%for i=2:n1;  	yb(i)=y(i+1)-y(i-1); 	end;

rx = rx(ts1:te1);	xx = xx(ts1:te1);	n = length(xx);
rx = rx/2./xx;	tb = [ones(n,1) xx]; 	b1 = regress(rx,tb); 
r = b1(1);	xm = -b1(1)/b1(2);

% Ԥ����һ�� x(n+1)
%'����  ��  ~  ��   x0��      r       xm   Ԥ����һ��'
% r=.2557;	xm=392.0886;		% �̲�1860~1990���
% r=.2490;	xm=433.9886;		% �̲�1860~2000���
xn1 = xx(n)+r*xx(n)*(1-xx(n)/xm);
result=[1,ts,te,t0,r,xm,xn1];  
disp(['  1  ',int2str(ts),' ~ ',int2str(te),'  ',int2str(t0),'  ', num2str(r),'  ',num2str(xm),'  ',num2str(xn1)])

%����2-----------------------------------------------------------------------
y=x(ts1:te1);	
nn=size(y);  	n=nn(1);    		n1=n-1;		% n ������ڵ��� 3
yb=1:n; yb=yb';
yb(1)=(-3*y(1)+4*y(2)-y(3));	yb(n)=(3*y(n)-4*y(n-1)+y(n-2));
for i=2:n1;  	yb(i)=y(i+1)-y(i-1); 	end;

yb=yb/2./y;	tb=[ones(n,1) y]; 	b1=regress(yb,tb); 
r=b1(1);	xm=-b1(1)/b1(2);

% Ԥ����һ�� x(n+1)
%'����  ��  ~  ��   x0��      r       xm   Ԥ����һ��'
xn1 = xx(n)+r*xx(n)*(1-xx(n)/xm);
result(2,:)=[2,ts,te,t0,r,xm,xn1];  
disp(['  2  ',int2str(ts),' ~ ',int2str(te),'  ',int2str(t0),'  ', num2str(r),'  ',num2str(xm),'  ',num2str(xn1)])
