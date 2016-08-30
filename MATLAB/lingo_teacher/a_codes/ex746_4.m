% ��ѧ��ѧʵ��|2  p.154|163  ��7.4 (p.148��7.2)
% ��� min(x^2/a +y^2/b), a = 10 b = 2 
% ��ֵ [ 1, 1] 
a = 10; b =1;
x0 = [1 1];
x = fminunc(@ex741_2f, x0, [], a, b)  %=��7.2
% ���н��
%x =   1.0e-007 * (   0.0513   -0.1291  )

opt = optimset('fminunc');		%��ȡfminunc������ȱʡ�Ŀ��Ʋ���ֵ
opt = optimset(opt, 'Disp', 'iter');	%���� ����м���
x = fminunc(@ex741_2f, x0, opt, a, b)
% ���н��
%                                                        Directional 
%Iteration  Func-count     f(x)         Step-size      derivative 
%    1           2              1.1       0.544554          -4.04  
%    2           8        0.0809191       0.504496     -1.28e-008  
%    3          15     1.69215e-016        4.95545     -2.25e-009  
%
%Optimization terminated successfully:
% Search direction less than 2*options.TolX
%
%x =   1.0e-007 * (   0.0513   -0.1291  )

opt = optimset('fminunc');		%��ȡfminunc������ȱʡ�Ŀ��Ʋ���ֵ
opt = optimset(opt, 'tolx', 1e-16, 'tolf', 1e-16);	%���� ���ƾ���
[ x, fv, ef, out ] = fminunc(@ex741_2f, x0, opt, a, b)
% ���н��
%x =  1.0e-008 * (    0.2521    0.0902  )
%fv =  1.4492e-018		%����ֵ
%ef =     1			% 1:����
%out = 
%       iterations: 4		%��������
%       funcCount: 25		%Ŀ�꺯�����ô���
%       stepsize: 0.1415	%����������
%       firstorderopt: 2.7468e-008  %һ�������������ݶȵķ�����
%       algorithm: 'medium-scale: Quasi-Newton line search'	%�����㷨��'�еȹ�ģ:��ţ����������'

