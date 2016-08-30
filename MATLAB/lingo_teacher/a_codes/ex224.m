% p31-36 ���� 1790-2000 ���� �˿�Ԥ��
% ��������� dx/dt/x ����ֵ΢�����㹫ʽ�����̲� p71��

clear
x=[3.9 5.3 7.2 9.6 12.9 17.1 23.2 31.4 38.6 50.2 62.9 76 92 106.5 123.2 131.7 150.7 179.3 204 226.5 251.4 281.4]';
y=log(x);
n=22;     		tt=[0:(n-1)]';
%----------------------------------------------------------------
aa1.name='ָ������ģ�� 1790~1900  r x0';
n=12;     		t=[0:(n-1)]';
yb=y(1:n);    		tb=[ones(n,1),t];
[b1,bint1,r1,rint1,stats1]=regress(yb,tb);
r=b1(2);		x0=exp(b1(1));
aa1.value=[r,x0]; 	disp(aa1)
%--------------------
aa1.xhat=x0*exp(r*tt);				
plot(t,x(1:n),'+',t,x0*exp(r*t),'linewidth',2)	  % p.35ͼ2.8(a)
title(aa1.name),legend('ԭʼ����',aa1.name(1:16),'location','northwest')
pause

%----------------------------------------------------------------
aa2.name='ָ������ģ�� 1790~2000  r x0';
n=22;     		t=[0:(n-1)]';
yb=y(1:n);    		tb=[ones(n,1),t];
[b1,bint1,r1,rint1,stats1]=regress(yb,tb);
r=b1(2);		x0=exp(b1(1));
aa2.value=[r,x0]; 	disp(aa2)
%--------------------
aa2.xhat=x0*exp(r*tt);
plot(t,x(1:n),'+',t,x0*exp(r*t),'linewidth',2)	 % p.35ͼ2.8(b)
title(aa2.name),legend('ԭʼ����',aa2.name(1:16),'location','northwest')
pause

%-----------------------------------
plot(tt,x,'+',tt,[aa1.xhat,aa2.xhat],'linewidth',2)	% 2.8(a)(b)���ͼ
axis([0,22,0 ,400])
legend('ԭʼ����',aa1.name(1:16),aa2.name(1:16),'location','northwest')
pause

%----------------------------------------------------------------
aa3.name='ָ������ģ�� 1900~2000  r x0';
n1=12;	   		 n2=22;	
n=n2-n1+1;		t=[0:(n-1)]';
yb=y(n1:n2);		tb=[ones(n,1),t];;
[b1,bint1,r1,rint1,stats1]=regress(yb,tb);
r=b1(2);		x0=exp(b1(1));
aa3.value=[r,x0]; 	disp(aa3)
%--------------------
aa3.xhat=x0*exp(r*(tt-n1+1));
plot(t,x(n1:n2),'+',t,x0*exp(r*t),'linewidth',2)	% ͼ2.8(c)*
title(aa3.name),legend('ԭʼ����',aa3.name(1:16),'location','northwest')
pause
%-----------------------------------
plot(tt,x,'+',tt,[aa1.xhat,aa2.xhat,aa3.xhat],'linewidth',2) % ���ͼ2.8(a)(b)��ͼ(c)
axis([0,22,0 ,400])
legend('ԭʼ����',aa1.name(1:16),aa2.name(1:16),aa3.name(1:16),'location','northwest')

%----------------------------------------------------------------
t=1790:10:2000;
disp('��������ģ��: ����1:y1��ȫ��������ȡ  ����2:y1��ָ��������ȡ');
disp('����  ��  ~  ��   x0��      r       xm   Ԥ����һ��')     
r1=ex224logistic(t,x,1790,1790,1990);    
r2=ex224logistic(t,x,1790,1800,1990);
r3=ex224logistic(t,x,1790,1810,1990);
r4=ex224logistic(t,x,1790,1820,1990);
r5=ex224logistic(t,x,1790,1830,1990);
r6=ex224logistic(t,x,1790,1840,1990);
r7=ex224logistic(t,x,1790,1850,1990);
r8=ex224logistic(t,x,1790,1860,1990);
r9=ex224logistic(t,x,1790,1870,1990);
ra=ex224logistic(t,x,1790,1880,1990);
rb=ex224logistic(t,x,1790,1890,1990);
rc=ex224logistic(t,x,1790,1900,1990);
rd=ex224logistic(t,x,1790,1790,2000);
re=ex224logistic(t,x,1790,1860,2000);
rf=ex224logistic(t,x,1790,1900,2000);
rg=ex224logistic(t,x,1790,1910,2000);

%----------------------------------------------------------------
t=1790:10:2000;

rr=ex224logistic(t,x,1790,1790,1990); 
aa4.name='��������ģ�� 1790~1990';
r=rr(2,5);xm=rr(2,6);
aa4.value=[r,xm]
t1 = 0:21;  n = length(t1);
aa4.xhat = xm./(1+(xm/x(1)-1)*exp(-r*t1'));
plot(tt,x,'+',tt,aa4.xhat,'linewidth',2)	      % ͼ2.9*
title(aa4.name),legend('ԭʼ����',aa4.name,'location','northwest')
text(1,225,['r = ',num2str(r),',  xm = ',num2str(xm)])
pause

%------------------------------------
rr=ex224logistic(t,x,1790,1790,2000); 
aa5.name='��������ģ�� 1790~2000';
r=rr(2,5);xm=rr(2,6);
aa5.value=[r,xm]
t1 = 0:21;  n = length(t1);
aa5.xhat = xm./(1+(xm/x(1)-1)*exp(-r*t1'));
plot(tt,x,'+',tt,aa5.xhat,'linewidth',2)	      % ͼ2.9*
title(aa5.name),legend('ԭʼ����',aa5.name,'location','northwest')
text(1,225,['r = ',num2str(r),',  xm = ',num2str(xm)])
pause

%------------------------------------
rr=ex224logistic(t,x,1790,1860,1990); 
aa6.name='��������ģ�� 1860~1990';
r=rr(2,5);xm=rr(2,6);
aa6.value=[r,xm]
t1 = 0:21;  n = length(t1);
aa6.xhat = xm./(1+(xm/x(1)-1)*exp(-r*t1'));
plot(tt,x,'+',tt,aa6.xhat,'linewidth',2)	      % ͼ2.9*
title(aa6.name),legend('ԭʼ����',aa6.name,'location','northwest')
text(1,225,['r = ',num2str(r),',  xm = ',num2str(xm)])
pause

%------------------------------------
rr=ex224logistic(t,x,1790,1860,2000); 
aa7.name='��������ģ�� 1860~2000';
r=rr(2,5);xm=rr(2,6);
aa7.value=[r,xm]
t1 = 0:21;  n = length(t1);
aa7.xhat = xm./(1+(xm/x(1)-1)*exp(-r*t1'));
plot(tt,x,'+',tt,aa7.xhat,'linewidth',2)	      % ͼ2.9*
title(aa7.name),legend('ԭʼ����',aa7.name,'location','northwest')
text(1,225,['r = ',num2str(r),',  xm = ',num2str(xm)])
pause

%------------------------------------
aa8.name='��������ģ�� 1860~1990�̲��ϼ�����';
r=0.2557;xm=392.086;
aa8.value=[r,xm]
t1 = 0:21;  n = length(t1);
aa8.xhat = xm./(1+(xm/x(1)-1)*exp(-r*t1'));
plot(tt,x,'+',tt,aa8.xhat,'linewidth',2)	      % ͼ2.9
title(aa8.name),legend('ԭʼ����',aa8.name(1:16),'location','northwest')
text(1,225,['r = ',num2str(r),',  xm = ',num2str(xm)])
pause

%------------------------------------
aa9.name='��������ģ�� 1860~2000�̲��ϼ�����';
r=0.2490;xm=433.9886;
aa9.value=[r,xm]
t1 = 0:21;  n = length(t1);
aa9.xhat = xm./(1+(xm/x(1)-1)*exp(-r*t1'));
plot(tt,x,'+',tt,aa9.xhat,'linewidth',2)	      % ͼ2.9
title(aa9.name),legend('ԭʼ����',aa9.name(1:16),'location','northwest')
text(1,225,['r = ',num2str(r),',  xm = ',num2str(xm)])

