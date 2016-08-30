function f = ex745f(x, x0, y0, theta, sigma, d4, sigma4) 
% 大学数学实验  p.139-140,161-162 实验7 实例2  飞机精确定位问题
for i = 1:3
    f(i) = ( atan2(x(1) - x0(i), x(2) - y0(i) ) - theta(i) ) / sigma(i);
end
f(4) = ( sqrt( (x(1) - x0(4))^2 + (x(2) - y0(4))^2 ) - d4 ) /  sigma4;
