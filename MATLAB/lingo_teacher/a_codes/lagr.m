function y = lagr(x0,y0,x)
% ��ѧ��ѧʵ��  p.51    �������ղ�ֵ����
% n ���ڵ������� x0, y0 ����(ע�⣺��������n���ڵ㣬����ǰ����˵��n+1���ڵ�)
% m ����ֵ�������� x ����
% ������� y Ϊ m ����ֵ
%
n = length(x0);
m = length(x);
for i = 1:m
    z = x(i);
    s = 0;
    for k = 1:n
       p = 1;
       for j = 1:n
          if j ~= k
             p = p * (z - x0(j)) / (x0(k) - x0(j));
          end 
       end
       s = p * y0(k) + s;        
    end
    y(i) = s;
end
