% 大学数学实验2  p.47  
% 3.2.1.3 拉格朗日插值多项式的振荡 (Runge.m)
nn = [ 2 4 6 8 10 ]
x = -5:0.1:5;
z = zeros(1,length(x));
y = 1./(1+x.*x);		% x的函数值一g(x)
for n = nn
    x0 = linspace(-5,5,n+1);    % n+1 个节点的 x 坐标
    y0 = 1./(1+x0.*x0);         % n+1 个节点的 yx 坐标
    y1 = ex324lagr(x0,y0,x);		% 由 n+1 个节点产生 x 处的插值函数值	
    plot(x,y1,x,z,'k',x,y,'.k','linewidth',2),pause	%分别作图
    yy(n/2,:) = y1;
end
plot(x,yy,x,z,'k',x,y,'.k','linewidth',2)