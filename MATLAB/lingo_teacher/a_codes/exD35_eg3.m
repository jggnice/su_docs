%大学数学实验2 p.303-304,319-322  实验13 实例3 软件开发人员的薪金问题
%大学数学实验  p.290-292,307-311  实验12 实例3 软件开发人员的薪金问题

[A,B] = xlsread('dxsxsy2.xls', '13_3');

x1=A(:,3); 		%资历(年)
x2=A(:,4); 		%x2 = 1~ 管理，x2 = 0~ 非管理  
xx3=A(:,5);	%教育程度 1 2 3
y=A(:,2);		%软件开发人员的薪金
x3=xx3;		% 中学:x3=1, x4=0;  大学：x3=0, x4=1;  更高：x3=0, x4=0. 
x3(find(x3>1.1))=0;	
x4=zeros(46,1);	
x4(find(abs(xx3-2)<.1))=1;
x5=x2 + 2*xx3 - 1;	% x5是x2与xx3的组合取值1~6

% 第1个模型
x=[ones(46,1),x1,x2,x3,x4];
[b,bint,r,rint,stats]=regress(y,x);
b, bint, stats
plot(x1,r,'+'),pause
plot(x5,r,'+'),pause

% 第2个模型 + 交互作用
x=[ones(46,1),x1,x2,x3,x4 x2.*x3,x2.*x4];
[b,bint,r,rint,stats]=regress(y,x);
b, bint, stats
plot(x1,r,'+'),pause
plot(x5,r,'+'),pause

% 第2个模型, 剔除第33点
x(33,:)=[];  
y(33)=[];
x1(33)=[];  
x5(33)=[];  
[b,bint,r,rint,stats]=regress(y,x);
b, bint, stats
plot(x1,r,'+'),pause
plot(x5,r,'+'),pause

