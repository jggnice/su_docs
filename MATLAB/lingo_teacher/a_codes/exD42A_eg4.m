% 大学数学实验2p.304-305,330-331  实验13 实例4 酶促反应
% 大学数学实验 p.292-293,320-321  实验12 实例4 酶促反应

[A,B] = xlsread('dxsxsy2.xls', '13_4');

x1=A(1:11,1); y1=A(1:11,2);	% x1, y1是未经处理的数据(n=11)，
x2=A(:,1);      y2=A(:,3);	% x2, y2是处理的数据(n=12)

plot(x1,y1,'o',x2,y2,'+'),grid,pause 		% 书p.293|305图2中的散点图

x=x1;
y=y1;
u=1./x;
v=1./y;
uu=[ones(11,1),u];
[b,bint,r,rint,stats]=regress(v,uu,0.05);
b,bint					% 书p.293|305结果

vv=uu*b;
beta1=1/b(1,1);	
beta2=b(2,1)/b(1,1);

xx=[0.01:0.01:1.15]';	
plot(u,v,'o',u,vv),grid,pause			% 书p.293|305图2
plot(x,y,'o',xx,beta1*xx./(beta2+xx)),grid,pause	% 书p.293|305图3

beta0=[beta1,beta2];				%取线性化模型的结果作为beta的初值
[beta,R,J]=nlinfit(x,y,'exD42fA',beta0);	%非线性回归系数beta的估计
betaci=nlparci(beta,R,J);			%回归系数beta的置信区间
beta,betaci					%输出beta的估计及置信区间
xx=0:0.1:1.2;
yy=beta(1)*xx./(beta(2)+xx);			%用beta的估计值计算y的预测值
%yy1=ex1204fA(beta,xx);
%[yy',yy1']					%yy与yy1相同
plot(x,y,'+',xx,yy)				% 书p.320|330图25

nlintool(x,y,'exD42fA',beta)			% 书p.320|330图26