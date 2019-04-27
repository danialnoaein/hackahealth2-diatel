//
//  RightimageTextfield.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class RightimageTextfield: UITextField {

    @IBInspectable var rightimage:UIImage?{
        didSet{
            updateview()
        }
    }
    
    func updateview(){
        if let image = rightimage{
            rightViewMode = .always
            
            let imageview = UIImageView(frame: CGRect(x: 0, y: 0, width: 35, height: 40));
            imageview.image = image;
            let view = UIView(frame: CGRect(x: 0, y: 0, width: 35, height: 40))
            view.addSubview(imageview);
            rightView = view
            
        }else{
            rightViewMode = .never
            
        }
        
        
        attributedPlaceholder = NSAttributedString(string: placeholder != nil ? placeholder! : "", attributes: [NSAttributedStringKey.foregroundColor  : tintColor])
    }

}
