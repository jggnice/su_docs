%目的：求两条曲线交点横坐标
format long%显示多位小数
clc;clear;%控制变量
x=(-2:0.1:2)';%列向量x
y(:,1)=sin(x);%列向量y1
y(:,2)=x.^2/2;%列向量y2
plot(x,y);grid;legend('sin(x)','x^{2}/2')%画图
opt = optimset('TolX',1e-10);
[x1,y,yy,yyy]=...
fzero(@(x)(x.^2/2-sin(x)),[1.3 1.5],opt)
[x2,y,yy,yyy]=...
fzero(@(x)(x.^2/2-sin(x)),[-0.3 0.3],opt)
[x3,y,yy,yyy]=...
fsolve(@(x)(x.^2/2-sin(x)),[1.3 1.5],opt)
[x4,y,yy,yyy]=...
fsolve(@(x)(x.^2/2-sin(x)),[-0.3 0.3],opt)

x10=[0 1.3];
for ii=1:30
    x10=sqrt(2*sin(x10));
end
x10
x11=[0 1.3];
for ii=1:30
    x11=x11-(sin(x11)-x11.^2/2)./(cos(x11)-x11);
end
x11
format short%有始有终，四位小数