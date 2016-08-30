% ��ѧ��ѧʵ��|2  p.174-175|179-180, p.175|185, p176|186  ʵ��8 ��1  ������Թ滮
% max z = 3x1 + x2      ==> min -3x1 - x2 
% s.t.  x1 �C  x2 >= �C2    ==> -x1 + x2 <= 2
%        x1 �C  2 x2 <= 2
%        3 x1 + 2 x2 <= 14
%      x1, x2 >= 0
clear
format short

A = [-1 1; 1 -2; 3 2];
b = [2 2 14]';
c = [-3 -1]';
v1 = [ 0 0 ]; 	% �½�

'***** p175������10������******'
% p175������10�����⣬
%               ans1��ǰ3��Ϊ���������кţ�
%              ��5��Ϊ���⣬����ȫ>=0���ǻ����н⣨��5����
m = size(A,1); 	% A ������
A1 = [A, eye(m)];	% ����m���ɳڱ���
n = size(A1, 2); 	% A1 ������
nn = 1:n;
n0 = zeros(1,5);
ans1 = [];
for  i = 1:n-1	% k��������k��ѭ��
    for j = i+1:n
       ij = nn;
       ij( [i, j] ) = [] ;    	% ɾȥ1:n�е�i, jԪ��
       B = A1(:, ij );	% ȡ��A������m��
       xB = (B\b)';	
       x = zeros(1,5);
       x( ij ) = xB ;
       ans1 = [ans1; ij, x];
   end
end
ans1

'*****p.176|185 ��linprog�������************'
[ x, f, exitflag, output, lamda ] = linprog( c, A, b, [], [], v1 )
lamda_ineqlin = lamda.ineqlin
lamda_eqlin = lamda.eqlin
lamda_upper = lamda.upper
lamda_lower = lamda.lower

' = = = = p.177|186 ��Ч������ = = = = '
opt1 = optimset('Largescale', 'off');
[ x, f, exitflag, output, lamda ] = linprog( c, A, b, [], [], [], [], [], opt1 )
' = = = = p.177|186 �������㷨 = = = = '
opt2 = optimset(opt1, 'simplex', 'on');	% 6.5������simplexѡ��
[ x, f, exitflag, output, lamda ] = linprog( c, A, b, [], [], [], [], [], opt2 )

% ���н��
% ans1 = 
% 3	4	5	0	0	2	2	14
% 2	4	5	0	2	0	6	10
% 2	3	5	0	-1	3	0	16
% 2	3	4	0	7	-5	16	0
% 1	4	5	-2	0	0	4	20
% 1	3	5	2	0	4	0	8
% 1	3	4	4.6667	0	6.6667	-2.6667	0
% 1	2	5	-6	-4	0	0	40
% 1	2	4	2	4	0	8	0
% 1	2	3	4	1	5	0	0
%Optimization terminated successfully.
%x =
%    4.0000
%    1.0000
%f =   -13.0000
%exitflag =     1
%output = 
%        iterations: 5
%    cgiterations: 0
%        algorithm: 'lipsol'
%lamda = 
%    ineqlin: [3x1 double]
%      eqlin: [0x1 double]
%      upper: [2x1 double]
%      lower: [2x1 double]
% amda_ineqlin =
%    0.0000		% ��Լ����������
%    0.3750		% ����Ӱ�Ӽ۸�(p.187-188)
%    0.8750		% ����Ӱ�Ӽ۸�(p.187-188)
%lamda_eqlin =
%   Empty matrix: 0-by-1
%lamda_upper =
%     0			% ��Լ����������
%     0			% ��Լ����������
%lamda_lower =
%  1.0e-008 *
%                    0.1075		
%                    0.2942

%  **********������2008������************

% = = = = p.177 ��Ч������ = = = = 
%Optimization terminated.
% x =
%     4
%     1
%f =   -13
%exitflag =     1
%output = 
%      iterations: 2
%       algorithm: 'medium-scale: active-set'
%    cgiterations: []
%         message: 'Optimization terminated.'
%lamda = 
%      lower: [2x1 double]
%      upper: [2x1 double]
%      eqlin: [0x1 double]
%    ineqlin: [3x1 double]

% = = = = p.177 �������㷨 = = = = 
%Optimization terminated.
%x =
%     4
%     1
%f =   -13
%exitflag =     1
%output = 
%      iterations: 2
%       algorithm: 'medium scale: simplex'
%    cgiterations: []
%         message: 'Optimization terminated.'
%lamda = 
%    ineqlin: [3x1 double]
%      eqlin: [0x1 double]
%      upper: [2x1 double]
%      lower: [2x1 double]


  