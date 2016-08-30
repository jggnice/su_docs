function y = ex1204fA(b,x)	%M文件，b是待估参数 
y = b(1)*x ./ (b(2) + x);		%模型1