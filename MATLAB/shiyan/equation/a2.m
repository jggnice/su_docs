clear
 x=solve('x^3+x-10=0')

%把x转换为double
y=double(x);
y=y(y>0&y<3)
%即可筛选出你要的范围内的实数解
%可以用fzero函数求出数值解，若是
%多项式方程，还可用root求根！