function f = ex745f(x, x0, y0, theta, sigma, d4, sigma4) 
% ��ѧ��ѧʵ��  p.139-140,161-162 ʵ��7 ʵ��2  �ɻ���ȷ��λ����
for i = 1:3
    f(i) = ( atan2(x(1) - x0(i), x(2) - y0(i) ) - theta(i) ) / sigma(i);
end
f(4) = ( sqrt( (x(1) - x0(4))^2 + (x(2) - y0(4))^2 ) - d4 ) /  sigma4;
