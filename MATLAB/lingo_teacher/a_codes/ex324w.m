% 大学数学实验2  p.50  (教材+王振羽)
% 3.2.4  用三种插值方法计算g(x)=1/(1+x^2),区间[-5,5], n=10等分
clear
clf,shg,      % CLF Clear current figure，SHG Show graph window
n = 10+1;  m = 10+1;
x0 = linspace(-5,5,n);
y0 = 1./(1+x0.^2);     % 产生节点 (x0,y0)

x = -5:0.1:5;          % 产生插值点x,间隔0.1 linspace(-5,5,m)
y = 1./(1+x.^2);plot(x,y),pause   % 计算 g(x),用于比较

x0 = -5:10/(n-1):5;
y0 = 1./(1+x0.^2);        % 产生节点 (x0,y0)	
y1 = ex324lagr(x0,y0,x);  % 计算拉格朗日插值
y2 = interp1(x0,y0,x);    % 计算分段线性插值
y3 = spline(x0,y0,x);     % 计算三次样条插值

k = 51:5:101;	  	  % 输出 x>=0 且间隔0.5的插值
[x(k); y(k); y1(k); y2(k); y3(k)]'  

z = 0*x;		 	% 产生横轴(作图用)
plot(x,z,x,y,'k--',x,y2,'r')	% 分段线性插值作图
title('分段线性插值'),pause	
plot(x,z,x,y,'k--',x,y3,'r')	% 三次样条插值作图
title('三次样条插值插值')