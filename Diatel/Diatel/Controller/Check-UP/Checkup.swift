//
//  Checkup
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class Checkup: UIViewController {

    @IBOutlet weak var DescriptionText: UITextView!
    @IBOutlet weak var addbtn: UIButton!
    @IBOutlet weak var diabetTest: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad();
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        
        view.setGradientBackground(colorTop: color1, colorBottom: color2)
        
        // Do any additional setup after loading the view, typically from a nib.
        DescriptionText.font = UIFont(name: "Shabnam-Bold", size: 18.0);
        addbtn.layer.cornerRadius = 10
        diabetTest.layer.cornerRadius = 10
        
    }

    
    //MARK: Actions
    /**********************************************************/
    @IBAction func addcheckup(_ sender: UIButton) {
        let vc = storyboard?.instantiateViewController(withIdentifier: "addcheckup") as! Addcheckup;
        present(vc, animated: true)
    }
    
    @IBAction func DiabetMachineTraning(_ sender: UIButton) {
        
        let vc = storyboard?.instantiateViewController(withIdentifier: "slidescontainer") as! SliderViewController;
        navigationController?.pushViewController(vc, animated: true)
    }
    
}

