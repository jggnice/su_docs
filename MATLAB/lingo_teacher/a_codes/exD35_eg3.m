%��ѧ��ѧʵ��2 p.303-304,319-322  ʵ��13 ʵ��3 ���������Ա��н������
%��ѧ��ѧʵ��  p.290-292,307-311  ʵ��12 ʵ��3 ���������Ա��н������

[A,B] = xlsread('dxsxsy2.xls', '13_3');

x1=A(:,3); 		%����(��)
x2=A(:,4); 		%x2 = 1~ ����x2 = 0~ �ǹ���  
xx3=A(:,5);	%�����̶� 1 2 3
y=A(:,2);		%���������Ա��н��
x3=xx3;		% ��ѧ:x3=1, x4=0;  ��ѧ��x3=0, x4=1;  ���ߣ�x3=0, x4=0. 
x3(find(x3>1.1))=0;	
x4=zeros(46,1);	
x4(find(abs(xx3-2)<.1))=1;
x5=x2 + 2*xx3 - 1;	% x5��x2��xx3�����ȡֵ1~6

% ��1��ģ��
x=[ones(46,1),x1,x2,x3,x4];
[b,bint,r,rint,stats]=regress(y,x);
b, bint, stats
plot(x1,r,'+'),pause
plot(x5,r,'+'),pause

% ��2��ģ�� + ��������
x=[ones(46,1),x1,x2,x3,x4 x2.*x3,x2.*x4];
[b,bint,r,rint,stats]=regress(y,x);
b, bint, stats
plot(x1,r,'+'),pause
plot(x5,r,'+'),pause

% ��2��ģ��, �޳���33��
x(33,:)=[];  
y(33)=[];
x1(33)=[];  
x5(33)=[];  
[b,bint,r,rint,stats]=regress(y,x);
b, bint, stats
plot(x1,r,'+'),pause
plot(x5,r,'+'),pause

