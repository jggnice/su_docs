function y = ex624f(x,a,b,c,d)	% ������Ϊex624f�ĺ�����a, b, c dΪF�����еĲ���
% ��ѧ��ѧʵ��  p.122 ��2 �õ�����ʽ (28) ��ⷽ���飬p.124 fsolve   
% ������� F(x) = {x1^2 + x2^2 = 4, x1^2 - x2^2 = 1}�� ��ֵ(1,1)'
%                   F'(x) = 2{x1  x2; x1,  -x2}
y(1) = x(1)^2 + a*x(2)^2 - b;	% a =  1, b = 4ʱΪ��1������
y(2) = x(1)^2 + c*x(2)^2 - d;	% c = -1, d = 1ʱΪ��2������
