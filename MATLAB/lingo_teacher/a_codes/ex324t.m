% 大学数学实验2  p.50  (唐煜)
% 3.2.4  用三种插值方法计算g(x)=1/(1+x^2),区间[-5,5], n=10等分
clf,shg,      % CLF Clear current figure
n = 11;  m = 21;
x = -5:10/(m-1):5;                % 产生插值点x,间隔0.1
y = 1./(1+x.^2);plot(x,y),pause   % 计算 g(x),用于比较

x0 = -5:10/(n-1):5;
y0 = 1./(1+x0.^2);       % 产生节点 (x0,y0)	
y1 = ex324lagr(x0,y0,x);hold on,plot(x,y1,'r'),pause   % 计算拉格朗日插值
y2 = interp1(x0,y0,x);hold on,plot(x,y2,'b'),pause     % 计算分段线性插值
y3 = interp1(x0,y0,x,'spline');hold on,plot(x,y3,'k*') % 计算三次样条插值


% s='      x         y        y1         y2        y3'
% [x(11:21)' y(11:21)' y1(11:21)' y2(11:21)' y3(11:21)']
