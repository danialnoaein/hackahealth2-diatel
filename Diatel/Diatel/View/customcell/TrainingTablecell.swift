//
//  TrainingTablecell.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class TrainingTablecell: UITableViewCell {

    @IBOutlet weak var container: UIView!
    @IBOutlet weak var imagePlaceholder: UIImageView!
    @IBOutlet weak var titleText: UILabel!
    @IBOutlet weak var datetext: UILabel!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        container.layer.cornerRadius = 10
        imagePlaceholder.clipsToBounds = true
        imagePlaceholder.layer.cornerRadius = 10
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
