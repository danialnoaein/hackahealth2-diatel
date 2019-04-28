//
//  ThirdViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/8/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class ThirdViewController: UIViewController {

    @IBOutlet weak var familyBackground: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        view.setGradientBackground(colorTop: color1, colorBottom: color2)
        
        // Do any additional setup after loading the view.
        let toolbar = UIToolbar();
        toolbar.sizeToFit();
        let donebutton = UIBarButtonItem(title: "بستن", style: UIBarButtonItemStyle.done, target: self, action: #selector(self.doneclick));
        
        toolbar.setItems([donebutton], animated: false);
        familyBackground.layer.borderColor = UIColor.white.cgColor
        familyBackground.layer.borderWidth = 1
        familyBackground.layer.cornerRadius = 10
        familyBackground.inputAccessoryView = toolbar
    }

    @objc func doneclick() {
        self.view.endEditing(true)
    }
    @IBAction func checkboxTapped(_ sender: UIButton) {
        if sender.image(for: .normal) == #imageLiteral(resourceName: "unchecked-checkbox"){
            sender.setImage(#imageLiteral(resourceName: "checked-checkbox"), for: .normal)
        }else{
            sender.setImage(#imageLiteral(resourceName: "unchecked-checkbox"), for: .normal)
        }
    }
    

}
