% ��ѧ��ѧʵ��2  p.99-101
% ��ѧ��ѧʵ��   p.97-99
A = [ 9 -1 -1; -1 10 -1; -1 -1 15]  	%��������
b=[7 8 13]'
A=[10 3 1;2 -10 3;1 3 10],b=[14 -5 14]'	%PPT����   
x = A\b
D = diag(diag(A))
L = -tril(A,-1)
U = -triu(A,1)	
x0 = [ 0 0 0 ]'

% �ſɱȣ�Jacobi������ 
BJ = D\(L+U)
fJ = D\b
xJ = x0; xJa = x0';
for i =1:4
  xJ = BJ*xJ + fJ ;
  xJa=[xJa; xJ'];
end

% ��˹-���¶�(Gauss-Sedeil)���� 
BGS = (D-L)\U
fGS = (D-L)\b
xG = x0;  xGa = x0';
for i =1:4
  xG = BGS*xG + fGS ;
  xGa=[xGa; xG'];
end
xJa,xGa


