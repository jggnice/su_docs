%mylu2.m
%列选主元
clear;clc;
nn=4;
A=[10 -7 0 1;
    -3 2.099999 6 2;
    5 -1 5 -1;
    2 1 0 2];
U=A;
b=[8 5.900001 5 1]';
P=eye(nn);
L=eye(nn);
Li=eye(nn);

for ii=1:length(A)-1
    [~,q2]=max(abs(U(ii:end,ii)));
    q2=q2+ii-1;
    Pi= pp1(eye(nn),ii,q2);
    P=Pi*P;
    U=Pi*U;
    L=Pi*L*Pi;
    b=Pi*b;
    
    Li=eye(nn);
    for jj=ii+1:length(A)
    tep=-U(jj,ii)/U(ii,ii);
    Li=pp2(Li,ii,jj,tep);
    end
    U=Li*U;
    L=Li*L;    
end
toL=inv(L),U
x=U\L*b
detA=det(U)