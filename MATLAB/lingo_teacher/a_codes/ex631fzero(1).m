% ��ѧ��ѧʵ��2 p.124 fzero��  % ��  p.118   ͼ�η� �еķ���
% ��ѧ��ѧʵ��  p.123 fzero��  % ��  p.116   ͼ�η� �еķ���
% ���� -1.75, -0.75, 1.00, 2.40 ����
f = inline('x^6 - 2*x^4 - 6*x^3 - 13*x^2 + 8*x + 12')
ezplot( f, [-2, 2.5]),grid		%��ͼ

x1 = fzero(f, -1.75);
x2 = fzero(f, -0.75);
x3 = fzero(f,  1.00);
x4 =fzero(f,  2.40);
x = [x1;x2;x3;x4];

x1a = fzero(f, [-2, -1.5]);
x2a = fzero(f, [-1, -0.5]);
x3a = fzero(f, [0.5,1.5]);
x4a = fzero(f, [  2, 2.5]);
xa = [x1a;x2a;x3a;x4a];

format long
[x,xa]
format

[ x, fv, ev, out ] = fzero(f, 2)

[ x, fv, ev, out, jac] = fsolve(f, 2)

% �����
%f =
%     Inline function:
%    f(x) = x^6 - 2*x^4 - 6*x^3 - 13*x^2 + 8*x + 12
%
%ans =
%  -1.74453992789401  -1.74453992789401
%  -0.78943412979625  -0.78943412979625
%   1.00000000000000   1.00000000000000
%   2.40883368438696   2.40883368438696
%
%x =     2.4088
%fv =  1.7764e-014	% fv��x���Ӧ�ĺ���ֵ
%ev =     1		% ����1��ʾ�ҵ���ŵ㣬����-1��ʾû���ҵ���ŵ�
%out = 	
%     iterations: 23	%������23��
%     funcCount: 23	%������������23��
%     algorithm: 'bisection, interpolation'	%�㷨�Ƕ��ַ��Ͳ�ֵ��
%
% Optimization terminated successfully:
% First-order optimality is less than options.TolFun.
%x =    2.4088
%fv =  2.0961e-013
%ev =     1
%out = 
%       iterations: 8	%������23��
%       funcCount: 15	%������������23��
%       algorithm: 'trust-region dogleg'	%�㷨������������������
%    firstorderopt: 4.5218e-011		% x�㴦�ݶ�������1-����
%jac =   215.7229	%x�㴦��Ӧ���ſɱȾ���

