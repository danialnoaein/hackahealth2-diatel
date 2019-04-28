//
//  ForthViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/8/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class ForthViewController: UIViewController {

    @IBOutlet weak var phonenumber: UITextField!
    @IBOutlet weak var phoneFriend: UITextField!
    @IBOutlet weak var comingBtn: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        let toolbar = UIToolbar();
        toolbar.sizeToFit();
        let donebutton = UIBarButtonItem(title: "بستن", style: UIBarButtonItemStyle.done, target: self, action: #selector(self.doneclick));
        
        toolbar.setItems([donebutton], animated: false);
        phonenumber.inputAccessoryView = toolbar;
        phoneFriend.inputAccessoryView = toolbar;
        phonenumber.layer.borderColor = UIColor.white.cgColor
        phoneFriend.layer.borderColor = UIColor.white.cgColor
        phonenumber.layer.borderWidth = 1
        phoneFriend.layer.borderWidth = 1
        phonenumber.layer.cornerRadius = 10
        phoneFriend.layer.cornerRadius = 10
        comingBtn.layer.cornerRadius = 10
    }
    
    @objc func doneclick() {
        self.view.endEditing(true)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }


    @IBAction func enterapp(_ sender: UIButton) {
        let vc = storyboard?.instantiateViewController(withIdentifier: "mainViewController") as! UITabBarController
        present(vc, animated: true)
    }
    
}
