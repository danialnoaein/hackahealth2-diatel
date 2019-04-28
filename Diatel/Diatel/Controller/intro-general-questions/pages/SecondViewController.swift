//
//  SecondViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/8/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {

    @IBOutlet weak var height: UITextField!
    @IBOutlet weak var weight: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        let toolbar = UIToolbar();
        toolbar.sizeToFit();
        let donebutton = UIBarButtonItem(title: "بستن", style: UIBarButtonItemStyle.done, target: self, action: #selector(self.doneclick));
        
        toolbar.setItems([donebutton], animated: false);
        
        height.inputAccessoryView = toolbar;
        weight.inputAccessoryView = toolbar;
        height.layer.borderColor = UIColor.white.cgColor
        weight.layer.borderColor = UIColor.white.cgColor
        height.layer.borderWidth = 1
        weight.layer.borderWidth = 1
        height.layer.cornerRadius = 10
        weight.layer.cornerRadius = 10
    }
    @objc func doneclick() {
        self.view.endEditing(true)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }

    @IBAction func nexttopage(_ sender: UIButton) {
        let pageController = self.parent as! UIPageViewController
        
        pageController.goToNextPage()
    }
    
}
