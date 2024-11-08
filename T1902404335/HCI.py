import tkinter as tk;
from tkinter import messagebox
root = tk.Tk()
root.geometry("700x500")
root.resizable(False, False)
root.title("WELCOME")

def fun():
    tk.messagebox.showinfo()

l1 = tk.Label(root, text="WELCOME", font = 44, foreground="red")
l1.place(x= 230,y = 30)

l2 = tk.Label(root, text="Thank you for visiting the website! We hope you enjoy your time here. ", font= 32)
l2.place(x= 20, y= 200)

l3 = tk.Label(root, text="Enter the username")
l3.place(x= 20, y= 70)
e1 = tk.Entry(root)
e1.place(x= 140, y= 70)

l4 = tk.Label(root, text="Enter contact info")
l4.place(x= 20, y= 90)
e2 = tk.Entry(root) #type= "*")
e2.place(x= 140, y= 90)

b1 = tk.Button(root, text="Do not have a account? Click here", activebackground= "blue", command = fun, activeforeground= "white")
b1.place(x= 40, y = 130)

b2 = tk.Button(root, text= "LOGIN", activebackground = "red", command = fun)
b2.place(x= 320, y = 74)


root.mainloop()
