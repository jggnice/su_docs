clc;
x0=[0 0];
opt=optimset('Largescale','off','maxfunevals',1000,'tolfun',1e-10);
[x,fv,ef,out]=fminunc(@homew,x0,opt)